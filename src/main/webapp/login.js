document.addEventListener("DOMContentLoaded", function() {});

var user = "";
var pass = "";

document.getElementById("login").addEventListener("click", function(e) {
  e.preventDefault();
  // user = document.getElementById("user").value;
  // pass = document.getElementById("password").value;
  console.log(user);
  console.log(pass);

  let employee = {
    userName: (user = document.getElementById("user").value),
    password: (pass = document.getElementById("password").value)
  };

  axios
    .post("/clockwork/api/employee", employee)
    .then(response => {
      console.log(employee);
      console.log(response);
    })
    .catch(message => {
      console.log({ message });
    });
});
