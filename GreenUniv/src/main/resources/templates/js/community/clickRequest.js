// <th> 태그를 갖는 <tr> 태그를 제외한 모든 <tr>에 스타일 및 이벤트 리스너를 적용
for (let i = 1; i < len; i++) {
  const currentTr = tr[i];
  // table 안의 모든 <tr> 태그 클릭 시 HTTP GET 요청 전송
  currentTr.addEventListener("click", async () => {
    await onClick(currentTr);
  });
}

/**
 * <tr> 태그를 클릭할 경우 호출되는 함수. <tr> 태그 내부의 <a> 태그를 찾아서 "href" 속성의 값을 가져온다.
 * 가져온 href 속성 값을 request()의 인자로 넘겨 HTTP 요청을 전송한다.
 * @param {*} tr 이벤트 함수를 적용할 <tr> 태그.
 */
async function onClick(tr) {
  const anchor = tr.querySelector("td a");
  const url = anchor.getAttribute("href");
  await request(url);
}
