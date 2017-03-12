import React, {Component} from 'react';
import {requireNativeComponent, Dimensions} from 'react-native';
const RNNativeListviewView = requireNativeComponent('NativeListviewView', null);

class NativeListview extends Component {

    render() {
        return (
            <RNNativeListviewView {...this.props}>
            </RNNativeListviewView>
        );
    }
}

NativeListview.propTypes = {
    setBulletin: React.PropTypes.string.isRequired,
    setSelectedOddList : React.PropTypes.string.isRequired
};

export default NativeListview;
