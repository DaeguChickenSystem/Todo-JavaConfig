//액션타입 정의
import update from 'react-addons-update';
import * as types from '../actions/actionTypes';

//모듈 초기상태 정의
const initialState = {
  main: "ALL",
  view: types.PRDCT_LIST,
  past: {}
};

export default function reducer(state= initialState, action){

const { past, status, view} = state;


switch(action.type){
 case types.PRDCT_LIST:
  return update(state, {  status: { $set: "ALL"}, view:{ $set: types.PRDCT_LIST}, past: { $set: {status:status, view: view}}  });
case types.PRDCT_DTL:
    return  update(state, {
            status: { $set: "ALL"}, view:{ $set: types.PRDCT_DTL},  past: { $set:  {status:status, view: view}}
    });

 default:
   return state;
   }
 }
