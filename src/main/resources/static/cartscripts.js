document.addEventListener("DOMContentLoaded", () => {
    const cartTableBody = document.querySelector("#cartTable tbody");
    const cartNum = document.getElementById("cartNum");
    const cartTotal = document.getElementById("cartTotal");

    fetch('/cart')
        .then(response => response.json())
        .then(data => {
            renderCart(data.cartItems, data.cartTotal, data.cartNum);
        });

    function renderCart(cartItems, total, num) {
        cartTableBody.innerHTML = "";
        cartItems.forEach(item => {
            const row = document.createElement("tr");

            row.innerHTML = `
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>
                    <input type="number" value="${item.quantity}" min="1" data-id="${item.product.id}" class="updateQuantity">
                </td>
                <td>${item.product.price * item.quantity}</td>
                <td>
                    <button class="removeItem" data-id="${item.product.id}">Remove</button>
                </td>
            `;
            cartTableBody.appendChild(row);
        });

        cartNum.textContent = num;
        cartTotal.textContent = total;
    }

    cartTableBody.addEventListener("change", (e) => {
        if (e.target.classList.contains("updateQuantity")) {
            const id = e.target.dataset.id;
            const quantity = e.target.value;

            fetch(`/update/${id}.html`, {
                method: "POST",
                headers: { "Content-Type": "application/x-www-form-urlencoded" },
                body: `quantity=${quantity}`
            })
                .then(response => response.json())
                .then(data => renderCart(data.cartItems, data.cartTotal, data.cartNum));
        }
    });

    cartTableBody.addEventListener("click", (e) => {
        if (e.target.classList.contains("removeItem")) {
            const id = e.target.dataset.id;

            fetch(`/remove/${id}.html`)
                .then(response => response.json())
                .then(data => renderCart(data.cartItems, data.cartTotal, data.cartNum));
        }
    });
});
