const priceRange = document.getElementById('price-range');
const minPriceInput = document.getElementById('minPrice');
const maxPriceInput = document.getElementById('maxPrice');
const selectedMinPriceDisplay = document.getElementById('selectedMinPrice');
const selectedMaxPriceDisplay = document.getElementById('selectedMaxPrice');

let minValue = parseFloat(minPriceInput.value);
let maxValue = parseFloat(maxPriceInput.value);

noUiSlider.create(priceRange, {
  start: [minValue, maxValue],
  connect: true,
  range: {
    min: minValue,
    max: maxValue,
  },
});

priceRange.noUiSlider.on('update', function (values, handle) {
  const selectedMinPrice = parseFloat(values[0]).toFixed(2);
  const selectedMaxPrice = parseFloat(values[1]).toFixed(2);
  selectedMinPriceDisplay.textContent = selectedMinPrice;
  selectedMaxPriceDisplay.textContent = selectedMaxPrice;
  minPriceInput.value = selectedMinPrice;
  maxPriceInput.value = selectedMaxPrice;
});
