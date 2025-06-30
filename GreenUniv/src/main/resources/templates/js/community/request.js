/**
 * 작성자: id3ntity99(이현민)
 * 설명 : 게시물 클릭 시 서버로 HTTP 요청을 보내도록 하는 자바스크립트 코드
 */

/**
 * HTTP 응답의 상태 코드가 200일 경우 실행되는 핸들러 함수.
 * @param {*} response 서버로부터 전달받은 HTTP response
 */
function handleOK(response) {
  console.log(`${response.url}로의 요청이 성공적으로 완료되었습니다.`);
}

/**
 * HTTP 응답의 상태 코드가 400번대일 경우 실행되는 핸들러 함수.
 * @param {*} response 서버로부터 전달받은 HTTP response
 */
function handleErr(response) {
  console.log(`[DEBUG] 에러 발생! Status Code: ${response.status} `);
}

/**
 * HTTP 응답의 상태코드가 302번, 리다이렉션일 경우 실행되는 핸들러 함수.
 * 현재의 웹페이지 주소를 HTTP 리다이렉트 응답 메시지에 명시되어 있는 redirect URL로 변경한다.
 * @param {*} response 서버로부터 전달받은 HTTP response
 */
function handleRedirect(response) {
  window.location.replace(response.url);
}

/**
 * 기본 핸들러. HTTP Status Code 200, 302, 400~500번대 응답을 처리한다.
 * @param {*} response 서버로부터 전달받은 HTTP response.
 */
function defaultHandler(response) {
  if (response.status === 200) {
    handleOK(response);
  } else if (response.redirected) {
    handleRedirect(response);
  } else {
    handleErr(response);
  }
}

/**
 *  매개변수 URL로 HTTP GET 요청을 전송한다.
 * @param {*} url <a> 태그의 href 속성 값
 */
async function request(url) {
  requestWithHandler(url, defaultHandler);
}

/**
 * 매개변수 URL로 HTTP GET 요청을 전송한다.
 * @param {*} url 호스트 URL
 * @param {*} resHandlerFunc 요청에 대한 응답을 처리하는 함수.
 */
async function requestWithHandler(url, resHandlerFunc) {
  await fetch(url).then((response) => {
    resHandlerFunc(response);
  });
}

/**
 * 매개변수 URL로 HTTP POST 요청을 전송한다.
 * @param {*} url 호스트URL
 * @param {*} body HTTP POST 요청의 body에 포함될 JSON 데이터
 */
async function postRequest(url, body) {
  postRequestWithHandler(url, body, defaultHandler);
}

/**
 *
 * 매개변수 URL로 HTTP POST 요청을 전송한다.
 * @param {*} url 호스트URL
 * @param {*} body HTTP POST 요청의 body에 포함될 JSON 데이터
 * @param {*} handlerFunc 요청에 대한 응답을 처리하는 함수.
 */
async function postRequestWithHandler(url, body, handlerFunc) {
  await fetch(url, {
    method: "POST",
    body: body,
    "Content-type": "application/json;charset=utf-8",
  }).then((response) => {
    handlerFunc(response);
  });
}
