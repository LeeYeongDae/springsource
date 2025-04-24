
document.querySelector(".list-group").addEventListener("click", (e) => {
     const chk = e.target;
     console.log(chk.checked);

     const id = chk.closest("label").dataset.id;

     const actionform = document.querySelector('#actionform');
     actionform.id.value = id;
     actionform.completed.value = chk.checked;

     actionform.submit();
});
