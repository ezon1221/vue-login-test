<template>
  <div>
    <input type="text" placeholder="아이디" :value="value" @input="$emit('input', $event.target.value)">
  </div>
</template>

<script>
export default {
  props: ['value']
}
</script>
