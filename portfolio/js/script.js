$(function () {

  //ページ内スクロール
  var navHeight = $(".header").outerHeight();

  $('a[href^="#"]').on("click", function () {
    var href = $(this).attr("href");
    var target = $(href == "#" || href == "" ? "html" : href);
    var position = target.offset().top - navHeight;
    $("html, body").animate({ scrollTop: position, }, 300, "swing");
    return false;
  });

  //ページトップ
  $("#js-page-top").on("click", function () {
    $("body,html").animate({ scrollTop: 0, }, 300);
    return false;
  });

});

// モーダルを開く
function openModal(imageSrc) {
  var modal = document.getElementById("modal");
  var modalImage = document.getElementById("modal-image");
  modal.style.display = "block";
  modalImage.src = imageSrc;
}

// モーダルを閉じる
function closeModal() {
  var modal = document.getElementById("modal");
  modal.style.display = "none";
}


