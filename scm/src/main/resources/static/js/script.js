console.log("Script Load");

// change theme
let currentTheme = getTheme();

//initial -->
changeTheme();

//TODO:

function changeTheme(){
    // set to web page
    document.querySelector("html").classList.add(currentTheme);

    // set the kistener to change theme button
    const changeThemeButton = document.querySelector("#theme_change_button");

    // change the text
    changeThemeButton.querySelector('span').textContent = currentTheme == "light" ? "Dark" : "Light";

    // click event
    changeThemeButton.addEventListener("click", (event) => {
        const oldTheme = currentTheme;
        console.log("change theme button clicked.");

        if(currentTheme === "dark"){
            // theme light
            currentTheme = "light";
        }
        else{
            // theme dark
            currentTheme = "dark";
        }

        // local storage mein update
        setTheme(currentTheme);

        // remove current theme
        document.querySelector("html").classList.remove(oldTheme);

        // set current theme
        document.querySelector("html").classList.add(currentTheme);

        // change the text
        changeThemeButton.querySelector('span').textContent = currentTheme == "light" ? "Dark" : "Light";
    });
}

// set theme to local storage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}

// get theme from local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    
    // if (theme){
    //     return theme;
    // }
    // else{
    //     return "light";
    // }

    // or conditional operator

    return theme ? theme : "light";
}