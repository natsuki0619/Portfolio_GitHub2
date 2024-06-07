// drag-and-drop.js

// ドラッグ許可
function allowDrop(event) {
    event.preventDefault();
}

// ドラッグ開始
function drag(event) {
    // ドラッグ開始イベントのターゲットの親要素のIDを設定
    event.dataTransfer.setData("text", event.target.closest('.product').id);
}

// ドロップ
function drop(event) {
    event.preventDefault();
    const data = event.dataTransfer.getData("text");
    console.log('Data:', data); // デバッグ用出力
    const item = document.getElementById(data);
    console.log('Item:', item); // デバッグ用出力
    if (item) {
        const price = parseInt(item.getAttribute("data-price"), 10);
        addToCart(price);
    } else {
        console.error('Item not found for ID:', data);
    }
}


// カートに追加
function addToCart(price) {
    const totalElement = document.getElementById("total-price");
    const currentTotal = parseInt(totalElement.getAttribute("data-total"), 10) || 0;
    const newTotal = currentTotal + price;
    totalElement.setAttribute("data-total", newTotal);
    totalElement.textContent = `合計金額: ¥${newTotal}`;
}