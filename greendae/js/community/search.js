/**
 *  작성자: id3ntity99(이현민)
 *  설명 : 서버에 검색 키워드와 선택한 옵션을 전송하는 자바스크립트
 */

import URLEnum from "/js/url/URLEnum.js";

const form = document.getElementById("search-form");
const searchBox = document.getElementsByClassName("search-box")[0];
const select = document.querySelector("#search-area > select");
const options = document.querySelectorAll("#search-area > select > option");
const searchBtn = document.getElementsByClassName("search-btn")[0];
const url = new URLEnum();

form.addEventListener("submit", (event) => {
  event.preventDefault();
});

function handleSearch(response) {
  if (response.status === 200) {
    console.log(
      `[TEST] 검색 요청이 성공적으로 전송되었습니다. URL = ${requestURL}`
    );
  } else if (response.status / 100 === 4) {
    handleErr(response);
  }
}

searchBtn.addEventListener("click", async () => {
  const selectedIndex = select.selectedIndex;
  const selectedOption = options[selectedIndex].value;
  const requestURL = `${url.searchURL}?keyword=${searchBox.value}&option=${selectedOption}`;
  await requestWithHandler(requestURL, handleSearch);
});
