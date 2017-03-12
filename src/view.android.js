import React, {Component} from 'react';
import {requireNativeComponent, Dimensions} from 'react-native';
const RNNativeListviewView = requireNativeComponent('NativeListviewView', null);

class NativeListview extends Component {

    nativeListViewRef;

    render() {
        return (
            <RNNativeListviewView ref={(ref) => this.nativeListViewRef = ref} {...this.props}>
            </RNNativeListviewView>
        );
    }
}

NativeListview.propTypes = {
    setBulletin: React.PropTypes.string.isRequired
};

export default NativeListview;
