import React from 'react';
import ReactDOM from 'react-dom';
import { Router, Route,  IndexRoute } from 'react-router';
import App from './mainApp';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import reducers from './reducers';
import thunk from 'redux-thunk';

const store = createStore(reducers, applyMiddleware(thunk));
const rootElement = document.getElementById('root');


ReactDOM.render(
    <Provider store={store}>
        <Router>
            <Route path="/" component={App}>
                <IndexRoute component={App} />
            </Route>
        </Router>
        </Provider>
  , rootElement
);

store.subscribe(()=>{ console.log(store.getState()) });
