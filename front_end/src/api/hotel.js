import { axios } from '@/utils/request'
const api = {
    hotelPre: '/api/hotel'
}
export function getHotelsAPI() {
    return axios({
        url: `${api.hotelPre}/all`,
        method: 'get',
    })
}
export function getHotelByIdAPI(param) {
    return axios({
        url: `${api.hotelPre}/${param.hotelId}/detail`,
        method: 'GET',
    })
}
export function getHotelRateAPI(orderId) {
    return axios({
        url: `${api.hotelPre}/${orderId}/getHotelRate`,
        method: 'get',
    })
}
