<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Registration</h2>
    <form @submit.prevent="registerUser" class="border rounded p-4 shadow">

      <div class="form-group">
        <label for="username">Name:</label>
        <input type="text" v-model="name" class="form-control" required>
      </div>

      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" v-model="username" class="form-control" required>
      </div>

      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" v-model="email" class="form-control" required>
      </div>

      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" v-model="password" class="form-control" required>
      </div>

      <button type="submit" class="btn btn-primary">Register</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      name: '',
      username: '',
      email: '',
      password: '',
    };
  },
  methods: {
    async registerUser() {
      const userData = {
        username: this.username,
        email: this.email,
        password: this.password,
        name: this.name
      };
    
      try {
      axios.post('http://127.0.0.1:9595/api/auth/signup', userData, {
        headers: {
          // 'Authorization': +basicAuth,
          'Access-Control-Allow-Origin': '*',
          'Content-Type': 'application/json',
        },
      })
          .then(response => {
            console.log("Success: " + JSON.stringify(response));
            // Handle the response based on the status
            if (response.status === 200) {
              this.$router.push("/friends");
            } else {
              console.error('Login failed:', response.message);
            }
          }).catch(error => {
        console.log("Error: " + JSON.stringify(error));
      });
        
      } catch (error) {
        console.error(error); // Handle registration error
      }
    },
  },
};
</script>
