const mobileWidth = 680;
const addMenuBackground = () => {
const pageWidth = window.innerWidth;
const bodyOffset = document.body.scrollTop || document.documentElement.scrollTop;
const navigation = document.querySelector("header nav");
if(pageWidth > mobileWidth){
bodyOffset > 0 ? navigation.classList.add("nav-fixed") : navigation.classList.remove("nav-fixed");
}
}
//navigation to each section
const onNavItemClick = () => {
const navItemsList = document.querySelectorAll(".section-link");
const navItems = [...navItemsList];
navItems.forEach(item =>{
  item.addEventListener('click', event =>{
    const sectionId = event.target.getAttribute("href") || event.target.dataset.href;
    if(sectionId !== "./log_in.html"){
      event.preventDefault();
    scrollTopSection(sectionId);
    }
  });
});
}

const scrollTopSection = sectionId => {
let sectionPosition , sectionOffset;
const navigationHeight = document.querySelector("header nav").offsetHeight;
const pageWidth = window.innerWidth;
if(sectionId !== "#"){
  sectionOffset = document.querySelector(sectionId).offsetTop;
  sectionPosition = pageWidth > mobileWidth ? sectionOffset - navigationHeight : sectionOffset;

}
else{
  sectionPosition = 0;
}
window.scrollTo({
'behavior' : 'smooth',
'left' : 0,
'top' : sectionPosition
})
}
/*
const reorderResponsiveMenu = ()=>{
  const pageWidth = window.innerWidth;
  const navigation = document.querySelector("header nav .navigation");
  const navContainer = document.querySelector("header nav .container")
  const navigationBody = document.querySelector("body >.navigation");
  if(pageWidth <= mobileWidth && navigation){
    document.body.insertAdjacentElement("afterbegin",navigation);
  }
  else if(pageWidth > mobileWidth && navigationBody){
    navContainer.insertAdjacentElement("beforeend" ,navigationBody);
  }
}
const mobileMenueToggle = () =>{
  const menueToggle = document.querySelector(".nav-toggle");
  menueToggle.addEventListener("click", () =>{
  const mobileNavigation = document.querySelector("body >.navigation");
  mobileNavigation.classList.toggle("navigation-opened");
  });
}
*/
window.addEventListener("scroll", () =>{
addMenuBackground();
});
/*
window.addEventListener("resize", () =>{
reorderResponsiveMenu();
});
*/

reorderResponsiveMenu();
//mobileMenueToggle();
onNavItemClick();

//validate registration form

const form = document.querySelector("#form");
const username = document.querySelector("#username");
const email = document.querySelector("#email");
const password = document.querySelector("#password");
const password2 = document.querySelector("#password2");

form.addEventListener("submit", (e) => {
  e.preventDefault();
  validateInputs();
});

const setError = (element, message) => {
  const inputControl = element.parentElement;
  const errorDisplay = inputControl.querySelector(".error");

  errorDisplay.innerText = message;
  inputControl.classList.add("error");
  inputControl.classList.remove("success");
};

const setSuccess = (element) => {
  const inputControl = element.parentElement;
  const errorDisplay = inputControl.querySelector(".error");

  errorDisplay.innerText = "";
  inputControl.classList.add("success");
  inputControl.classList.remove("error");
};

const isValidEmail = (email) => {
  const reg =
    /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return reg.test(String(email).toLowerCase());
};

const validateInputs = () => {
  const usernameValue = username.value.trim();
  const emailValue = email.value.trim();
  const passwordValue = password.value.trim();
  const password2Value = password2.value.trim();

  if (usernameValue === "") {
    setError(username, "Username is required");
  } else {
    setSuccess(username);
  }

  if (emailValue === "") {
    setError(email, "Email is required");
  } else if (!isValidEmail(emailValue)) {
    setError(email, "Provide a valid email address");
  } else {
    setSuccess(email);
  }

  if (passwordValue === "") {
    setError(password, "Password is required");
  } else if (passwordValue.length < 8) {
    setError(password, "Password must be at least 8 character.");
  } else {
    setSuccess(password);
  }

  if (password2Value === "") {
    setError(password2, "Please confirm your password");
  } else if (password2Value !== passwordValue) {
    setError(password2, "Passwords doesn't match");
  } else {
    setSuccess(password2);
  }
};
