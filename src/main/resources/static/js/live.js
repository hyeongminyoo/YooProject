// live.js

//Signaling server
//html 문서의 로딩이 다 끝날 때 실행
$(document).ready(function(){
    let socket = io("http://localhost:3000");
    //msg에서 키를 누를떄
    $("#msg").keydown(function(key){
        //해당하는 키가 엔터키(13) 일떄
        if(key.keyCode == 13){
            //msg_process를 클릭해준다.
            msg_process.click();
        }
    });
    
    //msg_process를 클릭할 때
    $("#msg_process").click(function(){
        //소켓에 send_msg라는 이벤트로 input에 #msg의 벨류를 담고 보내준다.
         socket.emit("send_msg", $("#msg").val());
        //#msg에 벨류값을 비워준다.
        $("#msg").val("");
    });
    
    //소켓 서버로 부터 send_msg를 통해 이벤트를 받을 경우 
    socket.on('send_msg', function(msg) {
        //div 태그를 만들어 텍스트를 msg로 지정을 한뒤 #chat_box에 추가를 시켜준다.
        $('<div></div>').text(msg).appendTo("#chat_box");
    });
    
    
    //=============================WEB RTC===========================================
    
    let localVideo = document.getElementById("localVideo");
    
    let isInitiator = false;
    let isChannelReady = false;
    let isStarted = false;
    let localStream;
    let remoteStream;
    let pc;
    
    navigator.mediaDevices.getUserMedia({
        video: true,
        audio: false,
    }).then(gotStream).catch((error) => console.error(error));
    
    function gotStream(stream){
        console.log("local 스트림 추가");
        localStream=stream;
        //localVideo에 미디어 객체를 저장
        localVideo.srcObject = stream;
        sendMessage("User Media 가져오기 성공!");
        if(isInitiator){
            
        }
        
    }
    
    function sendMessage(message){
        console.log('Client sending message : ', message);
        //해당 소켓을 통해 클라이언트에게 메세지 전송(?)
        socket.emit('message',message);
    }

    // 자신의 RTCPeerConnection 초기화, 상대방의 RTCPeerConnection과 연결 
    function maybeStart(){
        console.log("maybeStart() 메서드 : ", isStarted, localStream, isChannelReady);

        if(!isStarted && typeof localStream !== "undefined" && isChannelReady){
            console.log("Peer Connection 생성");
        }
    }


    function createPeerConnection(){
        try {
            pc = new RTCPeerConnection(null);
            pc.onicecandidate = handleIceCandidate;
            pc.onaddstream = handleRemoteStreamAdded;
        } catch (error) {
            alert("RTCPeerConnection 객체를 생성할 수 없음");
            return;
        }
    }

    function handleIceCandidate(event){
        console.log("iceCandidateEvent", event);
        if(event.candidate){
            sendMessage({
                type:"candidate",
                label: event.candidate.sdpMLineIndex,
                id: event.candidate.sdpMid,
                candidate: event.candidate.candidate
            })
        }else{
            console.log("end of candidates");
        }
    }

    function handleCreateOfferError(event){
        console.log("createOffer() error: ",event);
    }

    function handleRemoteStreamAdded(event){
        console.log("remote Stream Added");
    }


})

