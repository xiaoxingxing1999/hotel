<template>

    <div class="evaStar">
        <ul class="star">
            <li v-for="(itemClass,index) in itemClasses" :class="itemClass" class="star-item" @click="stars(index)" track-by="index"  v-bind:key="index"></li><!--性能优化 track-by 数据不改变时不会重新渲染-->
        </ul>
    </div>
</template>

<script>
    import { mapGetters, mapMutations, mapActions } from 'vuex'
    export default{
        name: 'addstar',
        data(){
            return{
                score: 0,
            }
        },
        props:['scr'],

        components: {
        },


        computed:{ //计算属性
            itemClasses(){
                let result = []; // 返回的是一个数组,用来遍历输出星星
                let score = Math.floor(this.score * 2 ) / 2; // 计算所有星星的数量

                let integer = Math.floor(score); // 整数星星判断
                for(let i=0;i<integer;i++){ // 整数星星使用on
                    result.push("on"); // 一个整数星星就push一个CLS_ON到数组
                }

                while(result.length < 5){// 余下的用无星星补全,使用off
                    result.push("off");
                }
                return result;
            }
        },
        methods:{
            ...mapMutations([
                'set_rate',

            ]),
            stars:function(index){
                this.score = index + 1

                this.set_rate(this.score)
            }
        }

    }
</script>

<style>@import "../../../src/static/star.css";</style>