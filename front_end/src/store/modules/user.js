import Vue from 'vue'
import router from '@/router'
import { getToken, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'
import { message } from 'ant-design-vue'
import {
    loginAPI,
    registerAPI,
    getUserInfoAPI,
    updateUserInfoAPI,
    addcreditAPI,
    getvipAPI,
} from '@/api/user'

import {
    getUserOrdersAPI,
    cancelOrderAPI,
    getOrderAPI,
    addOrderRateAPI,
    addOrderCommentAPI
} from '@/api/order'

const getDefaultState = () => {
    return {
        userId: '',
        userInfo: {

        },
        userOrderList: [

        ],
        idOrder:{
            id:-1
        },
        rate:0,
        comment:'',
        orderindex:-1,
        vipp:0,
    }
}

const user = {
    state : getDefaultState(),

    mutations: {
        reset_state: function(state) {
            state.token = '',
            state.userId = '',
            state.userInfo = {
                
            },
            state.userOrderList = []
        },
        set_rate: (state, data) => {
            state.rate = data
        },
        set_vip: (state, data) => {
            state.vipp = data
        },
        set_comment: (state, data) => {
            state.comment = data
        },
        set_currentIndex: (state, data) => {
            state.orderindex = data
        },
        set_token: function(state, token){
            state.token = token
        },
        set_email: (state, data) => {
            state.email = data
        },
        set_userId: (state, data) => {
            state.userId = data
        },
        set_userInfo: (state, data) => {
            state.userInfo = {
                ...state.userInfo,
                ...data
            }

        },
        set_userOrderList: (state, data) => {
            state.userOrderList = data
        },
        set_idOrder: (state,data)=>{
            state.idOrder=data
        },
    },

    actions: {
        getvip: async ({ commit }, userData) => {
            const res = await getvipAPI(userData)

            if(res){

                commit('set_vip', res)
            }

             },
        addcredit: async ({ dispatch, commit }, userData) => {
            const res = await addcreditAPI(userData)
            if(res){
                message.success('信用已增加')
            }
        },
        login: async ({ dispatch, commit }, userData) => {
            const res = await loginAPI(userData)
            if(res){
                setToken(res.id)
                commit('set_userId', res.id)
                dispatch('getUserInfo')
                router.push('/hotel/hotelList')
            }
        },
        register: async({ commit }, data) => {
            const res = await registerAPI(data)
            if(res){
                message.success('注册成功')
            }
        },
        getUserInfo({ state, commit }) {
            return new Promise((resolve, reject) => {
              getUserInfoAPI(state.userId).then(response => {
                const data = response
                if (!data) {
                  reject('登录已过期，请重新登录')
                }
                commit('set_userInfo', data)
                commit('set_userId', data.id)
                resolve(data)
              }).catch(error => {
                reject(error)
              })
            })
        },
        updateUserInfo: async({ state, dispatch }, data) => {
            const params = {
                id: state.userId,
                ...data,
            }
            const res = await updateUserInfoAPI(params)
            if(res){
                message.success('修改成功')
                dispatch('getUserInfo')
            }
        },
        getUserOrders: async({ state, commit }) => {
            const data = {
                userId: Number(state.userId)
            }
            const res = await getUserOrdersAPI(data)
            if(res){
                commit('set_userOrderList', res)
                console.log(state.userOrderList)
            }
        },
        cancelOrder: async({ state, dispatch }, orderId) => {
            const res = await cancelOrderAPI(orderId)
            if(res) {
                dispatch('getUserOrders')
                dispatch('getUserInfo')
                message.success('撤销成功')
            }else{
                message.error('撤销失败')
            }
        },
        logout: async({ commit }) => {
            removeToken()
            resetRouter()
            commit('reset_state')
        },
          // remove token
        resetToken({ commit }) {
            return new Promise(resolve => {
                removeToken() // must remove  token  first
                commit('reset_state')
                resolve()
            })
        },

        getOrderById: async({state,commit},data)=>{
            const res=await getOrderAPI(data)
            if(res){
                commit('set_idOrder',res)
            }
        },

        addOrderRate: async({state,commit})=>{
            const res=await addOrderRateAPI(state.orderindex,state.rate)
            if(res){
                message.success('成功')
            }
        },

        addOrderComment: async({state,commit})=>{
            const res=await addOrderCommentAPI(state.orderindex,state.comment)
            if(res){
                message.success('成功')
            }
        },

    }
}

export default user