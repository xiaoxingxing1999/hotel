<template>
    <div class="room-list">
        <div class="filter">
        </div>
        <div class="list">
            <a-table
                :columns="columns"
                :dataSource="rooms"
            >
                <span slot="price" slot-scope="text">
                    <span>￥{{ text }}</span>
                </span>
                <span slot="action" slot-scope="record">
                    <a-button type="primary" @click="order(record)">预定</a-button>
                </span>
                <span slot="delete" slot-scope="record">
                                            <a-popconfirm
                                                    title="确定想删除该房型吗？"
                                                    @confirm="deleteRoom(record)"
                                                    okText="确定"
                                                    cancelText="取消"
                                            >
                           <a-button type="danger"  v-if="aa">删除</a-button>
                        </a-popconfirm>

                </span>
            </a-table>
        </div>
        <OrderModal></OrderModal>
    </div>
</template>
<script>
import { mapGetters, mapActions, mapMutations } from 'vuex'
import OrderModal from './orderModal'
const columns = [
    {  
      title: '房型',
      dataIndex: 'roomType',
      key: 'roomType',
    },
    {
      title: '剩余房间数目',
      key: 'curNum',
      dataIndex: 'curNum',
    },
    {
      title: '房价',
      key: 'price',
      dataIndex: 'price',
      scopedSlots: { customRender: 'price'}
    },
    {
      title: 'Action',
      key: 'action',
      scopedSlots: { customRender: 'action' },
    },
    {
        title: 'Delete',
        key: 'delete',
        scopedSlots: { customRender: 'delete' },
    },
  ];
export default {
    name:'roomList',
    props: {
        rooms: {
            type: Array
        }
    },
    data() {
        return {
            columns,
            aa:true,
        }
    },
    components: {
        OrderModal
    },
    computed: {
        ...mapGetters([
            'orderModalVisible',
            'userInfo'
        ])
    },
    mounted() {
       this.aa=this.userInfo.userType=="HotelManager"
    },
    methods: {
        ...mapMutations([
            'set_orderModalVisible',
            'set_currentOrderRoom',
            'set_activeRoomId',
        ]),
        ...mapActions([
            'DdeleteRoom',
        ]),
        order(record) {
            if(this.userInfo.credit<-500){
                alert("您的信用值过低，如需解冻，请联系平台管理员")
                this.$router.push({name: 'hotelList'})
                return
            }
            this.set_currentOrderRoom(record)
            this.set_orderModalVisible(true)

        },
        deleteRoom(record){
            this.set_activeRoomId(record.id)

            this.DdeleteRoom()
        }
    }
}
</script>