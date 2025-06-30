import URLEnum from "../url/URLEnum";

/**
 * 작성자: id3ntity99(이현민)
 * 설명 : 서버에 수강신청 요청을 보내는 자바스크립트. 수강신청 버튼은 한번만 클릭할 수 있다.
 */
const url = new URLEnum();
const registerBtns = document.getElementsByClassName("register-btn");

/**
 * 모든 '신청' 버튼에 클릭 이벤트 리스너를 설정
 */
for (let registerBtn of registerBtns) {
  registerBtn.addEventListener("click", doRegister);
}

/**
 * 서버에 HTTP POST 요청을 전송하고 disable() 함수를 호출.
 * @param {*} event 이벤트 객체
 */
async function doRegister(event) {
  const handler = function (response) {
    console.log("[TEST] 수강신청이 완료되었습니다.");
    disable(event.target);
    event.target.removeEventListener("click", doRegister);
  };
  await postRequestWithHandler(url.registerLectureURL, ReportBody, handler);
}
