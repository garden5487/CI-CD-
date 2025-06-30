import URLEnum from "/js/url/URLEnum.js";

const url = new URLEnum();
const cancelBtns = document.getElementsByClassName("cancel-btn");

for (let cancelBtn of cancelBtns) {
  cancelBtn.addEventListener("click", doCancel);
}

async function doCancel(event) {
  function handleCancel(response) {}

  await request(url.cancelLectureRegisterURL, null); //TODO: request() 함수의 인자에 URL 및 JSON body 지정하기
  console.log("[TEST] 수강신청 취소가 완료되었습니다."); //TODO: console.log() 지우기
  disable(event.target);
  event.target.removeEventListener("click", doCancel);
}
