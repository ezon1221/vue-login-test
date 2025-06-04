<template>
  <div>
    <input type="password" placeholder="비밀번호" :value="value" @input="$emit('input', $event.target.value)">
  </div>
</template>

<script>
export default {
  props: ['value']
}
</script>
