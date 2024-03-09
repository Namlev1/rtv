const prices = document.querySelectorAll(".price");
prices.forEach((price) => {
    const regex = /^\d+\.\d$/
    if (regex.test(price.textContent)) {
        price.textContent += "0";
    }
})