import status from './status'
import rooms from './rooms'
import message from './message'
import mainStatus from './mainStatus'
import { combineReducers } from 'redux';

export default combineReducers({
  status, rooms, message, mainStatus
});
