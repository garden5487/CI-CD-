const titles = document.querySelectorAll("#container table tr a");
const MAX_TITLE_LEN = 30;
for (let title of titles) {
  const value = title.innerText;
  let concatTitle = "";
  if (value.length > MAX_TITLE_LEN) {
    concatTitle = value.substring(0, MAX_TITLE_LEN - 1);
    title.innerText = concatTitle + "...";
  }
}
