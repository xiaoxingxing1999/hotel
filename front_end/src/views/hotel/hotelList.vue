<template>
    <div>
        <div class="search">
        按照商圈搜索酒店：
    <a-select
            v-decorator="[
                    'bizRegion',
                    { rules: [{ required: true, message: '请选择商圈' }] }]"
            style="width: 120px"
            @change="handleChange"

    >
        <a-select-option value="XiDan">西单</a-select-option>
        <a-select-option value="WanDa">万达</a-select-option>
        <a-select-option value="XianLin">仙林</a-select-option>
        <a-select-option value="GuLou">鼓楼</a-select-option>
    </a-select>
            <a-divider></a-divider>
            <a-input-search
                    placeholder="请填写酒店名"
                    enter-button="Search"
                    size="large"
                    @search="onSearch"


            />
        </div>>
  <div class="hotelList">
    <a-layout>
        <a-layout-content style="min-width: 800px">
          <a-spin :spinning="hotelListLoading">
            <div class="card-wrapper">
                <HotelCard :hotel="item" v-for="item in hotelList" :key="item.index" @click.native="jumpToDetails(item.id)"></HotelCard>
                <div v-for="item in emptyBox" :key="item.name" class="emptyBox ant-col-xs-7 ant-col-lg-5 ant-col-xxl-3">
                </div>
                <a-pagination showQuickJumper :total="hotelList.totalElements" :defaultCurrent="1" @change="pageChange"></a-pagination>
            </div>
          </a-spin>
      </a-layout-content>
    </a-layout>
  </div>
    </div>
</template>
<script>
import HotelCard from './components/hotelCard'
import { mapGetters, mapActions, mapMutations } from 'vuex'

export default {
  name: 'home',
  components: {
    HotelCard
  },
  data(){
    return{
      emptyBox: [{ name: 'box1' }, { name: 'box2'}, {name: 'box3'}]
    }
  },
  async mounted() {
    await this.getHotelList()
  },
  computed: {
    ...mapGetters([
      'hotelList',
      'hotelListLoading'
    ])
  },
  methods: {
    ...mapMutations([
      'set_hotelListParams',
      'set_hotelListLoading'
    ]),
    ...mapActions([
      'getHotelList'
    ]),

    pageChange(page, pageSize) {
      const data = {
        pageNo: page - 1
      }
      this.set_hotelListParams(data)
      this.set_hotelListLoading(true)
      this.getHotelList()
    },
    jumpToDetails(id){
      this.$router.push({ name: 'hotelDetail', params: { hotelId: id }})
    },
      handleChange(value) {
          this.$router.push({ name: 'hotelsearchbybigregion', params: { bigRegion: value }})  ;
      },
      onSearch(value){
          this.$router.push({ name: 'hotelsearchbyname', params: { hotelname: value }})  ;
      }
  }
}
</script>
<style scoped lang="less">
  .hotelList {
    text-align: center;
    padding: -20px 0;
    .emptyBox {
      height: 0;
      margin: 10px 10px
    }
    .card-wrapper{
      display: flex;
      justify-content: space-around;
      flex-wrap: wrap;
      flex-grow: 3;
      min-height: 800px
    }
    .card-wrapper .card-item {
      margin: 30px;
      position: relative;
      height: 188px;
    }
  }
    .search{
        text-align: center;
        padding: 50px 0;
    }
</style>