const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/gs-guide-websocket'
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greeting', (greeting) => {
        showGreeting(JSON.parse(greeting.body).content);
    });
}

stompClient.onWebsocketError = (error) => {
    console.error('Error with websocket', error);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnected").prop("");
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.publish({
        destination: "/app/hello",
        body: JSON.stringify({'name': $("#name").val})
    })
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>"+ message + "</td></tr>")
}

$(function() {
    $("form").on('submit', (e) => e.preventDefault());
    $("#connect").click(() => connect());
    $("#disconnect").click(() => disconnect());
    $("#send").click(()=>sendName());
})
