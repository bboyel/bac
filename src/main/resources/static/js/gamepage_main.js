
window.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector(".form");
    const buttons = document.querySelectorAll(".btn[type='button']");
    const buttonReset = document.querySelector(".btn[type='reset']");
    const buttonSubmit = document.querySelector(".btn[type='submit']");
    const buttonNew = document.querySelector(".new");
    const input = document.querySelector(".input");
    const result = document.querySelector(".result");

    const customNumders = [];

    const disabledOn = btn => btn.setAttribute("disabled", "true");
    const disabledOff = btn => btn.removeAttribute("disabled");

    const setState = () => {
        input.value = customNumders.join("");

        if (customNumders.length === 4) {
            disabledOff(buttonSubmit);
            buttons.forEach(disabledOn);
        }
    };

    const resetNumbers = () => {
        customNumders.length = 0;
        setState();
        buttons.forEach(disabledOff);
        disabledOn(buttonSubmit);
    };

    const userWin = () => {
        customNumders.length = 0;
        input.value = customNumders.join("");
        buttons.forEach(disabledOn);
        disabledOn(buttonSubmit);
        disabledOn(buttonReset);
        disabledOff(buttonNew);
    }

    const addAnswer = answer => {
        const str = document.createElement("p");
        str.textContent = customNumders.join('') + ' - ' + answer;
        result.appendChild(str);
    };

    buttonNew.addEventListener("click", ({ target }) => {
        const data = {
            id: 907
        }

        fetch("/gamepage/newgame", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    result.textContent = "";
                    return;
                } else {
                    result.textContent = "Ошибка сервера";
                }
            })
            .then(() => {
                buttons.forEach(disabledOff);
                disabledOff(buttonReset);
                disabledOn(target);
            })
            .catch(() => {
                result.textContent = "Ошибка. Обратитесь к администратору";
            });
    });

    buttons.forEach(btn => {
        btn.addEventListener("click", () => {
            if (customNumders.length < 4) {
                customNumders.push(btn.textContent);
                setState();
                disabledOn(btn);
            }
        });
    });

    buttonReset.addEventListener("click", () => resetNumbers());

    form.addEventListener("submit", e => {
        e.preventDefault();

        if (customNumders.length !== 4) {
            return;
        }

        const data = {
            id: 907,
            userNumStr: customNumders.join("")
        };

        fetch("/gamepage/game", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(response =>
                response.ok ? response.json() : (result.textContent = "Ошибка сервера")
            )
            .then(json => {
                addAnswer(json.data.message);

                if (json.data.isWin) {
                    userWin();
                } else {
                    resetNumbers();
                }
            })
            .catch(() => {
                result.textContent = "Ошибка. Обратитесь к администратору";
            });
    });
});
