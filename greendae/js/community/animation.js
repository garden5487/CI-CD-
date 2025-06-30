/**
 * 작성자: id3ntity99(이현민)
 * 설명 : 각각의 게시물(<tr> 태그)에 마우스 포인터를 올릴 때 발생하는 애니메이션을 구현하는 자바스크립트
 */

const tr = document.querySelectorAll("#container table tr");
const len = tr.length;

// <th> 태그를 갖는 <tr> 태그를 제외한 모든 <tr>에 스타일 및 이벤트 리스너를 적용
for (let i = 1; i < len; i++) {
  const currentTr = tr[i];
  // table 안의 모든 <tr> 태그에 cursor: pointer; 스타일 설정
  currentTr.style.cursor = "pointer";

  // table 안의 모든 <tr> 태그에 애니메이션 설정
  currentTr.addEventListener("mouseover", () => {
    onMouseOver(currentTr);
  });

  currentTr.addEventListener("mouseout", () => {
    onMouseOut(currentTr);
  });
}

/**
 * 마우스 포인터가 <tr> 태그 위에 위치할 떄 호출되는 함수. <tr> 태그의 배경 색을 변경한다.
 * @param {*} tr 이벤트 함수를 적용할 <tr> 태그.
 */
function onMouseOver(tr) {
  tr.style.backgroundColor = "#fafafa";
}

/**
 * 마우스 포인터가 <tr> 태그를 벗어났을 때 호출되는 함수. <tr> 태그의 배경 색을 변경한다.
 * @param {*} tr 이벤트 함수를 적용할 <tr> 태그.
 */
function onMouseOut(tr) {
  tr.style.backgroundColor = "#fff";
}
