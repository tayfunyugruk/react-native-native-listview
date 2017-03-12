import React, {Component} from 'react';
import {requireNativeComponent, Dimensions, DeviceEventEmitter} from 'react-native';
const RNNativeListviewView = requireNativeComponent('NativeListviewView', null);

class NativeListview extends Component {

    componentWillMount() {
        DeviceEventEmitter.addListener('itemClicked', function (e) {
            console.log("itemClicked e ->", e);
        });
    }

    render() {
        return (
            <RNNativeListviewView {...this.props}>
            </RNNativeListviewView>
        );
    }
}

NativeListview.propTypes = {
    setBulletin: React.PropTypes.string.isRequired,
    setSelectedOddList: React.PropTypes.string.isRequired
};

export default NativeListview;
