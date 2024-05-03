const increaseButtons = document.querySelectorAll('.increase-button')
const decreaseButtons = document.querySelectorAll('.decrease-button')
const deleteButtons = document.querySelectorAll('.delete-cart-item')

increaseButtons.forEach((button) => {
  button.addEventListener('click', (event) => {
    const itemId = event.target.dataset.itemId;
    fetch(`/increase/${itemId}`, { method: 'POST' }).then(r => {
      location.reload();
    });
  });
});

decreaseButtons.forEach((button) => {
  button.addEventListener('click', (event) => {
    const itemId = event.target.dataset.itemId;
    fetch(`/decrease/${itemId}`, { method: 'POST' })
      .then(response => {
        location.reload();
      });
  });
});

deleteButtons.forEach((button) => {
  button.addEventListener('click', (event) => {
    const itemId = event.target.dataset.itemId;
    fetch(`/delete/${itemId}`, { method: 'POST' })
      .then(response => {
        location.reload();
      });
  });
});
