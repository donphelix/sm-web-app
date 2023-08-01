<template>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Friends</h2>
    <ul class="list-group">
      <li v-for="friend in friends" :key="friend.id" class="list-group-item d-flex justify-content-between align-items-center">
        {{ friend.title }}
        <div>
          <button @click="removeFriend(friend.id)" v-if="friend.added" class="btn btn-danger">Remove</button>
          <button @click="addFriend(friend.id)" v-else class="btn btn-primary">Add</button>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      friends: [],
    };
  },
  methods: {
    async addFriend(userId) {
      try {
        // Dummy implementation for adding a friend
        // This is where you would make the actual API call to add a friend
        console.log(`Added friend with ID: ${userId}`);
      } catch (error) {
        console.error(error); // Handle add friend error
      }
    },
    // eslint-disable-next-line no-unused-vars
    async removeFriend(userId) {
      try {
        // Dummy implementation for removing a friend
        // This is where you would make the actual API call to remove a friend
        console.log(`Removed friend with ID: ${userId}`);
      } catch (error) {
        console.error(error); // Handle remove friend error
      }
    },

    async getFriends() {
      try {
        const response = await axios.get('http://localhost:9595/api/posts');
        const {content} = response.data
        this.friends = content;
        console.log(content);
      } catch (error) {
        console.error("Friends error:", error);
      }
    },
  },

  async mounted() {
    // Call the getFriends method when the component is mounted
    this.getFriends();
  },
};
</script>
