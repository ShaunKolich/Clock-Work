document.getElementById("loginButton").addEventListener("click", function(e) {
  document.getElementById("timesheetButton").style.visibility = "hidden";
  document.getElementById("addTimeSheetId").style.visibility = "hidden";
  document.getElementById("timeSheetDivId").style.visibility = "hidden";
  e.preventDefault();

  user = {
    userName: document.getElementById("userName").value,
    password: document.getElementById("password").value,
    userId: "",
    firstName: "",
    lastName: "",
    role: "",
    jobTitle: ""
  };

  let promise = axios.post("http://localhost:8080/clockwork/api/user", user);

  promise.then(function(response) {
    //200s
    console.log(response.data);

    employee = response.data;
    console.log(employee.userId);
    document.getElementById("loginForm").innerText = "";

    let getPromise = axios.get(
      "http://localhost:8080/clockwork/api/timesheets?userId=" + employee.userId
    );

    getPromise.then(function(response) {
      console.log(response.data);

      response.log;

      document.getElementById("timeSheetDivId").removeAttribute("hidden", true);
      fillTimeSheet(response.data);
      document.getElementById("formHeader").innerText =
        "Logged In " + employee.firstName;
    });

    getPromise.catch(function(response) {
      console.log(response);
      console.log("user name not found");
    });
  });

  promise.catch(function(response) {
    console.log(response);
  });

  //////////////////////////////////

  document.getElementById("timesheetButton").style.visibility = "visible";
  document.getElementById("addTimeSheetId").style.visibility = "visible";
  document.getElementById("timeSheetDivId").style.visibility = "visible";

  document
    .getElementById("timesheetButton")
    .addEventListener("click", function(e) {
      let promise = axios.get(
        "http://localhost:8080/clockwork/api/timesheets?userId" +
          employee.userId
      );

      promise.then(function(response) {
        console.log(response.data);
        document.getElementById("timeSheetTableBody").innerText = "";

        TimeSheet(response.data);
      });

      promise.catch(function(response) {
        console.log(response);
      });
    });

  function updateTable(uId) {
    let promise = axios.get(
      "http://localhost:8080/clockwork/api/timesheets?userId=" + uId
    );

    promise.then(function(response) {
      response.log;
      document.getElementById("timeSheetTableBody").innerText = "";

      TimeSheet(response.data);
    });

    promise.catch(function(response) {
      console.log(response);
    });
  }

  //on loaded page on home.html

  document.addEventListener("DOMContentLoaded", function(e) {
    document.getElementById("timeSheetDivId").setAttribute("hidden", true);
  });

  function addName(user) {
    let fName = user.firstName;
    let lName = user.lastName;
    let uID = user.userId;

    getElementById("nameId").innerText = fName;
  }
  //timesheet object
  timeSheet = {
    timeSheetId: "",
    monHours: "",
    tueHours: "",
    wedhours: "",
    thuHours: "",
    friHours: "",
    weekEndDate: ""
  };

  //appends and adds a timesheet object to the table

  function appendTimesheet(timeSheet) {
    let mon = document.getElementById("mon");
    mon.innerHTML = "Mon";
    let tues = document.getElementById("tues");
    tues.innerHTML = "Tues";
    let wed = document.getElementById("wed");
    wed.innerHTML = "Wed";
    let thurs = document.getElementById("thurs");
    thurs.innerHTML = "Thurs";
    let fri = document.getElementById("fri");
    fri.innerHTML = "Fri";
    let total = document.getElementById("total");
    total.innerHTML = "Total Hours";
    let end = document.getElementById("ending");
    end.innerHTML = "End Date";

    let tr = document.getElementById("tableLayout");

    rt = document.createElement("tr");
    tr.appendChild(rt);
    let monData = document.createElement("td");
    let tueData = document.createElement("td");
    let wedData = document.createElement("td");
    let thrData = document.createElement("td");
    let friData = document.createElement("td");
    let totalData = document.createElement("td");
    let dateData = document.createElement("td");

    monData.setAttribute("id", "monData", +timeSheet.timeSheetId);
    tueData.setAttribute("id", +timeSheet.timeSheetId);
    wedData.setAttribute("id", +timeSheet.timeSheetId);
    thrData.setAttribute("id", +timeSheet.timeSheetId);
    friData.setAttribute("id", +timeSheet.timeSheetId);
    totalData.setAttribute("id", +timeSheet.timeSheetId);
    dateData.setAttribute("id", +timeSheet.timeSheetId);

    let editButton = document.createElement("button");
    let deleteButton = document.createElement("button");
    // let submitButton = document.createElement("button");

    editButton.setAttribute(
      "id",
      "editButton",
      "background-color:blue" + timeSheet.timeSheetId
    );
    editButton.setAttribute("value", timeSheet.timeSheetId);

    deleteButton.setAttribute("id", "deleteButton" + timeSheet.timeSheetId);
    deleteButton.setAttribute("value", timeSheet.timeSheetId);

    // submitButton.setAttribute("id", "timeSheet" + timeSheet.timeSheetId);
    // submitButton.setAttribute("value", timeSheet.timeSheetId);

    console.log("edit button id" + editButton.id);

    monData.innerText = timeSheet.monHours;
    console.log(monData);
    tueData.innerText = timeSheet.tueHours;
    wedData.innerText = timeSheet.wedHours;
    thrData.innerText = timeSheet.thuHours;
    friData.innerText = timeSheet.friHours;

    totalData.innerText =
      timeSheet.monHours +
      timeSheet.tueHours +
      timeSheet.wedHours +
      timeSheet.thuHours +
      timeSheet.friHours;

    let dateFormat = new Date(timeSheet.endDate);
    dateData.innerText = dateFormat.toLocaleDateString("en-US");

    editButton.innerText = "Edit";
    deleteButton.innerText = "Delete";
    // submitButton.innerText = "Submit";
    // tr.appendChild(rt);
    rt.appendChild(monData);
    rt.appendChild(tueData);
    rt.appendChild(wedData);
    rt.appendChild(thrData);
    rt.appendChild(friData);
    rt.appendChild(totalData);
    rt.appendChild(deleteButton);
    rt.appendChild(editButton);
    // tr.appendChild(dateData);
  }

  document
    .getElementById("timeSheetTable")
    .addEventListener("click", function(e) {
      //if submit butten pressed
      if (e.target.innerText == "Delete") {
        console.log("Delete clicked" + "e.target.value");

        let tsId = e.target.value;
        let apiUri =
          "http://localhost:8080/clockwork/api/timesheets?timesheetId=" + tsId;

        var deleteTimeSheetPromise = axios.delete(apiUri);

        deleteTimeSheetPromise.then(function(response) {
          console.log("delete process requested");
          updateTable(employee.userId); //update table
        });
      } else if (e.target.innerText == "Edit") {
        //e.target.innerText = 'Save';
        let thisTimesheetValue = e.target.value;
        console.log(thisTimesheetValue);

        document.getElement;
      }
    });


  function TimeSheet(list) {
    for (let timeSheet of list) {
      appendTimesheet(timeSheet);
      console.log(timeSheet);
    }
  }
});
