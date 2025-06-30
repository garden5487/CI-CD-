/**
 * 작성자: id3ntity99(이현민)
 * 설명 : '신청' 또는 '취소' 버튼을 비활성화 하는 자바스크립트
 */

/**
 * '신청' 버튼을 비활성화
 * @param {*} button
 */
function disable(button) {
  button.style.filter = "grayscale(100%)";
  button.style.cursor = "default";
}
