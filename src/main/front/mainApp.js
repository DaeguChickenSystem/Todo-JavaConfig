import React, { Component } from 'react';
import { connect } from 'react-redux';
import { layerRequest } from './actions/action';
import * as types from './actions/actionTypes';
import {leftSide, rightList, rightDetail} from './containers/main'
import './App.css';



class App extends Component {

 constructor(props){
   super(props);
   this.left = this.left.bind(this);
   this.right = this.right.bind(this);
 }

  left(){
	  return(
		 <div className="left"></div>	  
	  )
  }

  right(){
	  return(
				 <div className="right"></div>	  
			  )	  
  }
  render() {
    return (
    <div>
    	<div className="test">
    	  {this.left()}    	  
    	  {this.right()}
    	</div>

    </div>
    );
  }
}


const mapStateToProps = (state) => {
    return {
      view: state.mainStatus.view
    };
};


const mapDispatchToProps = (dispatch) => {
    return {
        layerRequest: (arg) => {
            return dispatch(layerRequest(arg));
        }
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(App);
