import { message } from 'ant-design-vue'
import store from '@/store'
import {
    getHotelsAPI,
    getHotelByIdAPI,
    getHotelRateAPI
} from '@/api/hotel'
import {
    reserveHotelAPI,
    sethasaddcreditAPI,
    gethasaddcreditAPI,
    getHotelOrdersAPI
} from '@/api/order'
import {
    orderMatchCouponsAPI,
} from '@/api/coupon'

const hotel = {
    state: {
        hotelList: [
            
        ],
        hotelListParams: {
            pageNo: 0,
            pageSize: 12
        },
        hotelListLoading: true,
        currentHotelId: '',
        currentHotelInfo: {

        },
        orderModalVisible: false,
        currentOrderRoom: {

        },
        orderMatchCouponList: [

        ],
        hasaddcredit:0,
        currenthotelorder:[],
        currentbigRegion:"",
        currentsearch:"",

    },
    mutations: {
        set_currentsearch: function(state, data) {
            state.currentsearch= data

        },
        set_currentbigRegion: function(state, data) {
            state.currentbigRegion = data

        },
        set_currenthotelorder: function(state, data) {
            state.currenthotelorder = data

        },
        set_hotelList: function(state, data) {
            state.hotelList = data

        },
        set_hotelListParams: function(state, data) {
            state.hotelListParams = {
                ...state.hotelListParams,
                ...data,
            }
        },
        set_hotelListLoading: function(state, data) {
            state.hotelListLoading = data
        },
        set_currentHotelId: function(state, data) {
            state.currentHotelId = data
        },
        set_currentHotelInfo: function(state, data) {
            state.currentHotelInfo = {
                ...state.currentHotelInfo,
                ...data,
            }
        },
        set_orderModalVisible: function(state, data) {
            state.orderModalVisible = data
        },
        set_currentOrderRoom: function(state, data) {
            state.currentOrderRoom = {
                ...state.currentOrderRoom,
                ...data,
            }
        },
        set_orderMatchCouponList: function(state, data) {
            state.orderMatchCouponList = data
        },
       set_hasaddcredit: function(state, data) {
           state.hasaddcredit = data
       }

},

    actions: {
        retrieveHotelOrders: async({commit, state}) => {

            const res = await getHotelOrdersAPI(state.currentHotelId)
            if(res){
                commit('set_currenthotelorder',res)
            }
        },
        sethasaddcredit: async({commit, state},data) => {

            const res = await sethasaddcreditAPI(data)
            if(res){
            }
        },
        gethasaddcredit: async({commit, state},data) => {

            const res = await gethasaddcreditAPI(data)
            if(res!=-1){
                commit('set_hasaddcredit',res)
            }
        },
        getHotelRate: async({commit, state},data) => {
            const res = await getHotelRateAPI(data)
            if(res){
                message.success('????????????')
            }
        },
        getHotelList: async({commit, state}) => {
            const res = await getHotelsAPI()
            if(res){
                commit('set_hotelList', res)
                commit('set_hotelListLoading', false)
            }
        },
        getHotelById: async({commit, state}) => {
            const res = await getHotelByIdAPI({
                hotelId: state.currentHotelId
            })
            if(res){
                commit('set_currentHotelInfo', res)
            }
        },
        addOrder: async({ state, commit }, data) => {
            const res = await reserveHotelAPI(data)
            console.log(res)
            if(res){
                message.success('????????????')
                commit('set_orderModalVisible', false)
            }
        },

        getOrderMatchCoupons: async({ state, commit }, data) => {
            const res = await orderMatchCouponsAPI(data)
            if(res){
                commit('set_orderMatchCouponList', res)
            }
        }
    }
}

export default hotel