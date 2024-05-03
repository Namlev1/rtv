const increaseButtons = document.querySelectorAll('.increase-button')
const decreaseButtons = document.querySelectorAll('.decrease-button')
const deleteButtons = document.querySelectorAll('.delete-cart-item')

increaseButtons.forEach((button) => {
  button.addEventListener('click', (event) => {
    const itemId = event.target.dataset.itemId;
    fetch(`/cart/increase/${itemId}`, { method: 'POST' }).then(r => {
      location.reload();
    });
  });
});

decreaseButtons.forEach((button) => {
  button.addEventListener('click', (event) => {
    const itemId = event.target.dataset.itemId;
    fetch(`/cart/decrease/${itemId}`, { method: 'POST' })
      .then(response => {
        location.reload();
      });
  });
});

deleteButtons.forEach((button) => {
  button.addEventListener('click', (event) => {
    const itemId = event.target.dataset.itemId;
    fetch(`/cart/delete/${itemId}`, { method: 'POST' })
      .then(response => {
        location.reload();
      });
  });
});
