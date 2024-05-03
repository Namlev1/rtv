const increaseButtons = document.querySelectorAll('.increase-button')
const decreaseButtons = document.querySelectorAll('.decrease-button')

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