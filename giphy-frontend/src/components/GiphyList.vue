<template>
  <div id="main">
      <giphy-card v-for="giphy in allTheGiphys" 
      :key="giphy.id" :giphy="giphy"/>
  </div>
</template>

<script>
import GiphyCard from './GiphyCard.vue'
export default {
  components: { GiphyCard },
    name: 'giphy-list',
    data() {
        return {
            allTheGiphys: this.$store.state.giphys,
        }
    }

}
</script>

<style scoped>
#main {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
}
</style>