import React, {Component} from 'react';
import {requireNativeComponent, Dimensions} from 'react-native';
import NativeListviewItem from './item';
const RNNativeListviewView = requireNativeComponent('NativeListviewView', null);

class NativeListview extends Component {

    componentWillUnmount() {

    }

    render() {
        return (
            <RNNativeListviewView {...this.props}>
            </RNNativeListviewView>
        );
    }
}

NativeListview.propTypes = {
    eventList: React.PropTypes.string.isRequired
};

export default NativeListview;
