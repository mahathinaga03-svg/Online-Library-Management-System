
const API_URL = "http://localhost:8080/api";

async function loadBooks(){
  try{
    const res = await fetch(API_URL + "/books");
    const books = await res.json();
    const tbody = document.getElementById("bookTable");
    if(!tbody) return;
    tbody.innerHTML = "";
    books.forEach(b=>{
      tbody.innerHTML += `<tr><td>${b.id}</td><td>${b.title}</td><td>${b.author}</td><td>${b.category}</td><td>${b.quantity}</td></tr>`;
    });
  }catch(e){
    console.log(e);
  }
}

async function addBook(){
  const book = {
    title: document.getElementById("title").value,
    author: document.getElementById("author").value,
    category: document.getElementById("category").value,
    isbn: document.getElementById("isbn").value,
    quantity: Number(document.getElementById("quantity").value)
  };
  await fetch(API_URL + "/books", {
    method:"POST",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(book)
  });
  alert("Book added successfully");
  loadBooks();
}

async function registerUser(){
  const user = {
    name: document.getElementById("name").value,
    email: document.getElementById("email").value,
    password: document.getElementById("password").value,
    role: document.getElementById("role").value
  };
  await fetch(API_URL + "/users/register", {
    method:"POST",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(user)
  });
  alert("User registered successfully");
}

async function loginUser(){
  const user = {
    email: document.getElementById("email").value,
    password: document.getElementById("password").value
  };
  const res = await fetch(API_URL + "/users/login", {
    method:"POST",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(user)
  });
  alert(await res.text());
}

async function issueBook(){
  const bookId=document.getElementById("bookId").value;
  const userId=document.getElementById("userId").value;
  const res=await fetch(API_URL + `/library/issue?bookId=${bookId}&userId=${userId}`,{method:"POST"});
  alert("Book issued successfully");
}

async function returnBook(){
  const recordId=document.getElementById("recordId").value;
  await fetch(API_URL + `/library/return?recordId=${recordId}`,{method:"POST"});
  alert("Book returned successfully");
}

window.onload = loadBooks;
