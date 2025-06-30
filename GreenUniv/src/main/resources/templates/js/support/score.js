import URLEnum from "/js/url/URLEnum.js";

const detailBtns = document.getElementsByClassName("detail-btn");
const form = document.getElementById("search-form");
const searchBtn = document.querySelector("#search-form search-btn");
const yearSelection = document.querySelector(".year-input");
const semesterSelection = document.querySelector(".semester-input");
const url = new URLEnum();

for (let detailBtn of detailBtns) {
  addListener(detailBtn);
}

form.addEventListener("submit", async (event) => {
  event.preventDefault();
  const selectedYearIndex = yearSelection.selectedIndex;
  const selectedSemesterIndex = semesterSelection.selectedIndex;
  const year = yearSelection.options[selectedYearIndex].value;
  const semester = semesterSelection.options[selectedSemesterIndex].value;
  await request(`/PATH/TO/SCORE/CONTROLLER?year=${year}&semester=${semester}`); //TODO: URL 삽입
});

function addListener(target) {
  target.addEventListener("click", async () => {
    await request(url.scoreDetailURL); //TODO: 필요시 URL 수정
    console.log("[TEST] 성공적으로 상세 페이지를 가져왔습니다.");
    $(function () {
      $("#dialog").dialog({
        resizable: false,
        width: 800,
        height: "auto",
        title: "성적조회 - 상세확인",
      });
    });
  });
}
