<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Login</h2>
    <form @submit.prevent="login" class="border rounded p-4 shadow">
      <div class="form-group">
        <label for="username">Username:</label>
        <input v-model="formData.usernameOrEmail" type="text" class="form-control" required />
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input v-model="formData.password" type="password" class="form-control" required />
      </div>
      <button type="submit" class="btn btn-primary stretched-link">Login</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      formData: {
        usernameOrEmail: '',
        password: '',
      },
    };
  },
  methods: {
    async login() {
      try {

        const username = this.formData.usernameOrEmail;
        const password = this.formData.password;
        const basicAuth = 'Basic ' + btoa(username + ':' + password);

        axios.post('http://127.0.0.1:9595/api/auth/signin', this.formData, {
            headers: {
              'Authorization': + basicAuth,
              'Access-Control-Allow-Origin': '*',
              'Content-Type': 'application/json',
            },
          })
          .then(response => {
            console.log("Success: " + JSON.stringify(response));
                  // Handle the response based on the status
                  if(response.status === 200) {
                    this.$router.push("/friends");
                  } else {
                    console.error('Login failed:', response.message);
                  }
          }).catch(error => {
            console.log("Error: " + JSON.stringify(error));
          });
      } catch (error) {
        // Handle login error here, e.g., show an error message
        console.error("Login error:", error);
      }
    },
  },
};
</script>
