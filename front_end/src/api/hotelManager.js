import { axios } from '@/utils/request'
const api = {
    hotelPre: '/api/hotel'
}
export function addRoomAPI(data) {
    return axios({
        url: `${api.hotelPre}/roomInfo`,
        method: 'POST',
        data,
    })
}
export function addHotelAPI(data) {
    return axios({
        url: `${api.hotelPre}/addHotel`,
        method: 'POST',
        data,
    })
}
export function deleteHotelAPI(hotelId) {
    return axios({
        url: `${api.hotelPre}/${hotelId}/deleteHotel`,
        method: 'GET',
    })
}
export function deleteRoomAPI(roomId) {
    return axios({
        url: `${api.hotelPre}/${roomId}/deleteRoom`,
        method: 'GET',
    })
}
