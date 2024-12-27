    function toggleDescription(productId) {
    console.log(`Clicked product ID: ${productId}`);

    const descriptions = document.querySelectorAll(".product-description");

    descriptions.forEach((desc) => {
    desc.style.display = "none";
});

    // Hiển thị mô tả của sản phẩm được chọn
    const selectedDesc = document.getElementById(`desc-${productId}`);
    if (selectedDesc) {
    selectedDesc.style.display = "block";
}
}


