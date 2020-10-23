const faqInfoBtns = document.querySelectorAll(".faq-info-btn");
const faqInfoAnswers = document.getElementsByClassName("faq-info-answer");

const navContainer = document.getElementById("nav-container");
const mainInfo = document.getElementById("main-info");
const pm = document.getElementsByClassName("plus-mines-first");

const popupExit = document.getElementsByClassName("popup-exit");
const popup = document.getElementById("popup");

for (let i = 0; i < popupExit.length; i++) {
  popupExit[i].addEventListener("click", function () {
    popup.classList.toggle("popup-active");
  });
}
mainInfo.setAttribute(
  "style",
  `margin-top: ${getComputedStyle(navContainer).minHeight}`
);

const menuBtn = document.getElementById("menu-btn");
const menu = document.querySelector(".navbar");
menuBtn.addEventListener("click", () => {
  menu.classList.toggle("navbar-active");
});

faqInfoBtns.forEach((btn, index) => {
  btn.addEventListener("click", function () {
    faqInfoAnswers[index].classList.toggle("faq-info-answer-active");
    pm[index].classList.toggle("plus-mines-active");
    faqInfoAnswers[index].classList.toggle(
      `faq-info-answer-active-height${index + 1}`
    );
  });
});

ymaps.ready(initMap);

function initMap() {
  new ymaps.Map(
    "map",
    {
      center: [53.9, 27.56659],
      zoom: 10,
    },
    {
      searchControlProvider: "yandex#search",
    }
  );
}
