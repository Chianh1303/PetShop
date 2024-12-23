
    function toggleDescription(productId) {
    const description = document.getElementById(`desc-${productId}`);
    if (description.style.display === "none") {
    description.style.display = "block";
} else {
    description.style.display = "none";
}
}
