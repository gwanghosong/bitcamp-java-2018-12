# uc009 - 채팅관리(ChatManagement)
- 본인에게 들어온 채팅내역을 조회, 삭제하는 것.

## 주 액터(Primary Actor)
회원

## 보조 액터(Secondary Actor)

## 사전 조건(Preconditions)
- 회원으로 로그인 되어 있다.

## 종료 조건(Postconditions)
- 본인의 채팅내역을 조회한다.
- 본인의 채팅내역을 삭제한다.

## 시나리오(Flow of Events)

### 

1. 액터는 채팅관리 유스케이스를 클릭한다.
2. 시스템은 채팅내역(아이디, 사진, 최근채팅날짜, 최근메시지1줄), 삭제버튼을 최근순으로 5개 출력한다.
3. 채팅내역을 클릭하면 채팅조회 유스케이스로 이동한다.
    - 삭제 조회를 클릭하면 해당 채팅내역을 삭제한다.


