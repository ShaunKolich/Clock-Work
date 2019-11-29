document.addEventListener("DOMContentLoaded", function () {

});

var user = '';
var pass = '';

document.getElementById('login').addEventListener('click', function (e) {
    e.preventDefault();
    user = document.getElementById("user").value;
    pass = document.getElementById("password").value;
    // console.log(user);
    // console.log(pass);


    let employee = {
        userName: user,
        password: password
    }

    console.log(user);
    console.log(pass);

    axios.post("http://localhost:8080/clockwork/api/employee", employee)
        .then(response => {
            console.log(response);
        })
        .catch(message => {

            console.log({ message });
        });



});


function addName(user){


  let fName = user.firstName;
  let lName = user.lastName;
  let uID = user.userId;

  getElementById('nameId').innerText = fName;


}

timeSheet = {
  timeSheetId: '',
  monHours: '',
  tueHours: '',
  wedhours: '',
  thuHours: '',
  friHours: '',
  endDate: ''

}

//appends and adds a timesheet object to the table
function appendTimesheet(timeSheet){

  let tr = document.createElement('tr');
  let monData = document.createElement('td');
  let tueData = document.createElement('td');
  let wedData = document.createElement('td');
  let thrData = document.createElement('td');
  let friData = document.createElement('td');
  let satData = document.createElement('td');
  let sunData = document.createElement('td');
  let statusData = document.createElement('td');
  let totalData = document.createElement('td');
  let dateData = document.createElement('td');

  let editButton = document.createElement('button');
  let deleteButton = document.createElement('button');
  let submitButton = document.createElement('button');

  editButton.setAttribute('id', 'editButton' + timeSheet.timeSheetId );
  editButton.setAttribute('value', timeSheet.timeSheetId);

  deleteButton.setAttribute('id', 'deleteButton' + timeSheet.timeSheetId);
  deleteButton.setAttribute('value', timeSheet.timeSheetId);

  submitButton.setAttribute('id', 'timeSheet' + timeSheet.timeSheetId);
  submitButton.setAttribute('value', timeSheet.timeSheetId);

  console.log('edit button id' + editButton.id);


  monData.innerText = timeSheet.monHours;
  tueData.innerText = timeSheet.tueHours;
  wedData.innerText = timeSheet.wedHours;
  thrData.innerText = timeSheet.thuHours;
  friData.innerText = timeSheet.friHours;


  totalData.innerText = timeSheet.monHours + timeSheet.tueHours + timeSheet.wedHours + timeSheet.thuHours + timeSheet.friHours;


  statusData.innerText = setStatus(timeSheet.statusId);
  let dateFormat = new Date(timeSheet.weekEndDate);
  dateData.innerText = dateFormat.toLocaleDateString("en-US");

  editButton.innerText = 'Edit';
  deleteButton.innerText = 'Delete';
  submitButton.innerText = 'Submit';

  tr.appendChild(monData);
  tr.appendChild(tueData);
  tr.appendChild(wedData);
  tr.appendChild(thrData);
  tr.appendChild(friData);
  tr.appendChild(totalData);
  tr.appendChild(dateData);

  if(statusData.innerText == 'Pending'){
      tr.appendChild(editButton);
      tr.appendChild(submitButton);
  }

  tr.appendChild(deleteButton);


  document.getElementById('timeSheetTable').appendChild(tr);


}

document.getElementById('timeSheetTable').addEventListener('click', function(e){

  console.log('timesheet table element clicked: target' + e.target);
  console.log('value: ' + e.target.value);
  console.log('ID: ' + e.target.id + " Inner Text: " + e.target.innerText);

  if(e.target.innerText == 'Submit'){
      let tsId = e.target.value;
      let apiUri = 'http://localhost:8080/clockwork/api/timesheets?timesheetId=' + tsId;
      let getPromise = axios.get(apiUri);

      getPromise.then(function(response){
          //200s
          console.log(response.data);
          var thisTimeSheet = response.data;
          thisTimeSheet.statusId = '2';

          let updateStatusPromise = axios.put("http://localhost:8080/clockwork/api/timesheets", thisTimeSheet);

          updateStatusPromise.then(function(updateResponse) {
              console.log("submit xhr successfull ");

          });

      });

  }else if(e.target.innerText == 'Delete'){
      console.log("Delete clicked" + "e.target.value");

      let tsId = e.target.value;
      let apiUri = 'http://localhost:8080/clockwork/api/timesheets?timesheetId=' + tsId;


      var deleteTimeSheetPromise = axios.delete(apiUri);

      deleteTimeSheetPromise.then(function(response){

          console.log("delete process requested");


       });
  }



});


function fillTimeSheet(list){

  for(let timeSheet of list){
      appendTimesheet(timeSheet);
  }

}

function setStatus (x){

  if(x == 2){
      return 'Submitted'
  }
  else{
      return 'Pending'
  }

}

