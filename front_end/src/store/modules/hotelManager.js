import {
    addRoomAPI,
    addHotelAPI,
    deleteHotelAPI,
    deleteRoomAPI,
} from '@/api/hotelManager'
import {
    getAllOrdersAPI,
    deleteOrderAPI,
    changeStatusAPI,
} from '@/api/order'
import {
    hotelAllCouponsAPI,
    hotelTargetMoneyAPI,     //导入api的定义
    hotelTargetTimeAPI,
    hotelTargetRoomAPI,
    deleteCouponAPI
} from '@/api/coupon'
import hotel from "./hotel";
import { message } from 'ant-design-vue'

const hotelManager = {
    state: {
        orderList: [],
        addHotelParams: {
            name: '',
            address: '',
            bizRegion:'XiDan',
            hotelStar:'',
            rate: 0,
            description:'',
            phoneNum:'',
            managerId:'',
        },
        addHotelModalVisible: false,
        addRoomParams: {
            roomType: '',
            hotelId: '',
            price: '',
            total: 0,
            curNum: 0,
        },
        addRoomModalVisible: false,
        couponVisible: false,
        addCouponVisible: false,
        activeHotelId: 0,
        activeRoomId:0,
        activeOrderId: 0,
        couponList: [],
    },
    mutations: {
        set_orderList: function(state, data) {
            state.orderList = data
        },
        set_addHotelModalVisible: function(state, data) {
            state.addHotelModalVisible = data
        },
        set_addHotelParams: function(state, data) {
            state.addHotelParams = {
                ...state.addHotelParams,
                ...data,
            }
        },
        set_addRoomModalVisible: function(state, data) {
            state.addRoomModalVisible = data
        },
        set_addRoomParams: function(state, data) {
            state.addRoomParams = {
                ...state.addRoomParams,
                ...data,
            }
        },
        set_couponVisible: function(state, data) {
            state.couponVisible = data
        },
        set_activeHotelId: function(state, data) {
            state.activeHotelId = data
        },
        set_activeRoomId: function(state, data) {
            state.activeRoomId = data
        },
        set_activeOrderId: function(state, data) {
            state.activeOrderId = data
        },
        set_couponList: function(state, data) {
            state.couponList = data
        },
        set_addCouponVisible: function(state, data) {
            state.addCouponVisible =data
        }
    },
    actions: {
        getAllOrders: async({ state, commit }) => {
            const res = await getAllOrdersAPI()
            if(res){
                commit('set_orderList', res)
            }
        },
        addHotel: async({ state, dispatch, commit }) => {
            const res = await addHotelAPI(state.addHotelParams)
            if(res){
                dispatch('getHotelList')
                commit('set_addHotelParams', {
                    name: '',
                    address: '',
                    bizRegion:'',
                    hotelStar:'',
                    rate: 0,
                    description:'',
                    phoneNum:'',
                    managerId:'',
                })
                commit('set_addHotelModalVisible', false)
                message.success('添加成功')
            }else{
                message.error('添加失败')
            }
        },

        DdeleteHotel: async({ state, dispatch, commit }) => {

            const res = await deleteHotelAPI(state.activeHotelId)

            if(res){

                dispatch('getHotelList')


                message.success('删除成功')
            }else{
                message.error('删除失败')
            }
        },
        DdeleteRoom: async({ state, dispatch, commit }) => {

            const res = await deleteRoomAPI(state.activeRoomId)

            if(res){

                message.success('删除成功')
                dispatch("getHotelById")
            }else{
                message.error('删除失败')
            }
        },
        DdeleteOrder: async({ state, dispatch, commit }) => {

            const res = await deleteOrderAPI(state.activeOrderId)

            if(res){

                dispatch('getAllOrders')


                message.success('删除成功')
            }else{
                message.error('删除失败')
            }
        },


        addRoom: async({ state, dispatch, commit }) => {
            const res = await addRoomAPI(state.addRoomParams)
            if(res){
                commit('set_addRoomModalVisible', false)
                commit('set_addRoomParams', {
                    roomType: '',
                    hotelId: '',
                    price: '',
                    total: 0,
                    curNum: 0,
                })
                message.success('添加成功')
            }else{
                message.error('添加失败')
            }
        },
        getHotelCoupon: async({ state, commit }) => {
            const res = await hotelAllCouponsAPI(state.activeHotelId)
            if(res) {
                // 获取到酒店策略之后的操作（将获取到的数组赋值给couponList）
                commit('set_couponList',res)
            }
        },
        ddeleteCoupon: async({ dispatch, commit },data) => {

            const res = await deleteCouponAPI(data)
            if(res) {
                // 获取到酒店策略之后的操作（将获取到的数组赋值给couponList）
                dispatch("getHotelCoupon")
            }
        },
        addHotelTargetMoneyCoupon: async({ commit, dispatch }, data) => {
            const res = await hotelTargetMoneyAPI(data)
            if(res){
                // 添加成功后的操作（提示文案、modal框显示与关闭，调用优惠列表策略等）
                dispatch('getHotelCoupon')
                commit('set_addCouponVisible',false)
                commit('set_couponVisible',true)
                message.success('添加策略成功')
            }else{
                // 添加失败后的操作
                message.error('添加失败')
            }
        },
        addHotelTargetTimeCoupon: async({ commit, dispatch }, data) => {
            const res = await hotelTargetTimeAPI(data)
            if(res){
                // 添加成功后的操作（提示文案、modal框显示与关闭，调用优惠列表策略等）
                dispatch('getHotelCoupon')
                commit('set_addCouponVisible',false)
                commit('set_couponVisible',true)
                message.success('添加策略成功')
            }else{
                // 添加失败后的操作
                message.error('添加失败')
            }
        },
        addHotelTargetRoomCoupon: async({ commit, dispatch }, data) => {
            const res = await hotelTargetRoomAPI(data)
            if(res){
                // 添加成功后的操作（提示文案、modal框显示与关闭，调用优惠列表策略等）
                dispatch('getHotelCoupon')
                commit('set_addCouponVisible',false)
                commit('set_couponVisible',true)
                message.success('添加策略成功')
            }else{
                // 添加失败后的操作
                message.error('添加失败')
            }
        },
        changeStatus: async({commit},data) =>{
            const res=await changeStatusAPI(data)
            if(res){
                message.success('更改状态成功')
            }
            else {
                message.error('更改失败')
            }
        }

    }
}
export default hotelManager